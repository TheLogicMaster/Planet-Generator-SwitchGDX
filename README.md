# Planet-Generator
A program that generates random, pixel planets and allows you to customize them. Built in LibGDX. Inspired by [planetarium](https://managore.itch.io/planetarium).

This game can be [downloaded on itch.io](https://zyangur.itch.io/observatory).

# Installation
If you want to run the program from source, clone the repository, and then follow the import, run, and debug your project steps for your preferred IDE located on the [LibGDX Website](https://libgdx.badlogicgames.com/documentation.html).

## SwitchGDX
The [SwitchGDX](https://github.com/TheLogicMaster/switch-gdx) backend enables support for more portable
target platforms by transpiling to C++ using [Clearwing VM](https://github.com/TheLogicMaster/clearwing-vm).
The primary target is a Nintendo Switch Homebrew application.

### Windows
- Install MSYS2
- Open a mingw64 shell: `C:\msys64\msys2_shell.cmd -mingw64`
- Install dependencies: `pacman -S gcc git rsync texinfo mingw-w64-x86_64-cmake mingw-w64-x86_64-zziplib mingw-w64-x86_64-glew mingw-w64-x86_64-SDL2_mixer mingw-w64-x86_64-freetype mingw-w64-x86_64-bullet`
- Install [devkitPro Updater](https://github.com/devkitPro/installer/releases/latest) with Switch packages selected (Leave downloaded files)
- Open DevKitPro's MSYS2: `C:\devkitPro\msys2\msys2_shell.cmd -mingw64`
- Install dependencies: `pacman -S switch-zlib switch-zziplib switch-sdl2_mixer switch-libvorbis switch-freetype switch-glad switch-curl dkp-toolchain-vars texinfo`
- Build LibFFI for Switch

### Linux
- Install CMake, Ninja, Rsync, Texinfo, SDL2, SDL2_Mixer, GLEW, libffi, zlib, zziplib, freetype
- With APT: `sudo apt install build-essential texinfo rsync cmake ninja-build libffi-dev libzzip-dev libsdl2-dev libsdl2-mixer-dev zlib1g-dev libglew-dev libfreetype-dev libcurl4-gnutls-dev`
- Install [devkitPro pacman](https://github.com/devkitPro/pacman/releases/tag/v1.0.2)
- `dkp-pacman -S switch-zlib switch-sdl2 switch-sdl2_mixer switch-freetype switch-glad switch-curl switch-bulletphysics dkp-toolchain-vars`
- Build LibFFI for Switch

### Switch Homebrew
- The `NRO` task builds a Homebrew application
- The `Deploy` task uses NXLink to deploy to a Switch running the Homebrew Launcher

### UWP
- Install CMake for Windows
- Install Visual Studio 2022 and C++/UWP support (`Desktop development with C++`, `Windows application development`)
- Run twice for DLLs to properly be copied for some reason

### LibFFI
This is a library that has to be compiled and installed manually for Switch. Run this for Linux normally and on Windows under MSYS2. Ensure that the working directory doesn't contain any spaces.
```bash
git clone https://github.com/libffi/libffi.git
cd libffi
./autogen.sh
source $DEVKITPRO/switchvars.sh
source $DEVKITPRO/devkita64.sh
CFLAGS="-g -O2 -march=armv8-a -mtune=cortex-a57 -mtp=soft -fPIC -ftls-model=local-exec" CHOST=aarch64-none-elf ./configure --prefix="$DEVKITPRO/portlibs/switch" --host=aarch64-none-elf
make install
```

# Images
![Alt text](http://imgur.com/z2qY1rp.png "Planet with multiple rings and moons")
![Alt text](http://imgur.com/ttKSzbq.png "Planet with moons")
![Alt text](http://imgur.com/1TtRZ52.png "Planet with one rings and moons")
![Alt text](http://imgur.com/e31XT6X.png "Planet with editor")
![Alt text](http://imgur.com/2V5yDnE.png "Planet with editor and moon trajectories")
