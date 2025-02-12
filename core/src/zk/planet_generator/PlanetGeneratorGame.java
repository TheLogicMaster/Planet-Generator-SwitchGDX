package zk.planet_generator;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.kotcrab.vis.ui.VisUI;
//import com.sun.org.apache.xpath.internal.operations.Or;
//import org.omg.CORBA.ORB;
import zk.planet_generator.scene_objects.*;
import zk.planet_generator.ui.EditorUI;
import zk.planet_generator.ui.SceneUI;

import javax.swing.*;

/**
 * Planet shader code: https://gamedev.stackexchange.com/questions/9346/2d-shader-to-draw-representation-of-rotating-sphere
 * Noise generator code: http://devmag.org.za/2009/04/25/perlin-noise/
 */
public class PlanetGeneratorGame extends ApplicationAdapter {
    private Scene scene;
    private EditorUI editorUI;
    private SceneUI sceneUI;
    private InputMultiplexer inputMultiplexer;

    @Override
    public void create() {
        VisUI.load(VisUI.SkinScale.X2);

        scene = new Scene();
        editorUI = new EditorUI(this);
        sceneUI = new SceneUI(this);

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(scene);
        inputMultiplexer.addProcessor(editorUI.getStage());
        inputMultiplexer.addProcessor(sceneUI.getStage());
        Gdx.input.setInputProcessor(inputMultiplexer);

        sceneUI.hide();
    }

    @Override
    public void render() {
        super.render();

        float delta = Gdx.graphics.getDeltaTime();

        scene.update(delta);
        editorUI.render(delta);
        sceneUI.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
        scene.dispose();
        editorUI.dispose();
        sceneUI.dispose();
        VisUI.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        editorUI.resize(width, height);
        sceneUI.resize(width, height);
    }

    public Scene getScene() {
        return scene;
    }

    public EditorUI getEditorUI() {
        return editorUI;
    }

    public SceneUI getSceneUI() {
        return sceneUI;
    }

    public void addProcessor(InputProcessor inputProcessor) {
        inputMultiplexer.addProcessor(inputProcessor);
    }

    public void removeProcessor(InputProcessor inputProcessor) {
        inputMultiplexer.removeProcessor(inputProcessor);
    }

    public void saveScene(String path) {
        Json json = new Json();
        json.toJson(scene, Gdx.files.absolute(path));
    }

    public void loadScene(String path) {
        Json json = new Json();
        scene.dispose();
        scene = json.fromJson(Scene.class, Gdx.files.absolute(path));
    }
}