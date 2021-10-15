# stressapp
Sample app to test stressapptest on android for creating memory pressure on device.

## Running stressapptest
1. Build static library for stressapptest according to your architecture. Repository already has binaries pre-built for x86 architecture, [here](https://github.com/amanjeetsingh150/stressapp/tree/main/stressapptest/libs/x86).
2. Use the following set of commands to push the static library in your data file system, make it executable and run a stress test for 20 seconds of 990 MBs
```
adb push stressapptest /data/local/tmp/
adb shell chmod 777  /data/local/tmp/stressapptest
adb shell /data/local/tmp/stressapptest -s 20 -M 990 -C 8
```
-s for total time you want to run memory stress, -M for megabytes of ram to test, -C for total threads to be used for stressing memory, defaults to number of CPUs.
Details of other options are here in [documentation](https://android.googlesource.com/platform/external/stressapptest/).

## Effect on device during stress-test

<p align="center">
<img src=https://user-images.githubusercontent.com/12881364/137557263-efe78254-417c-427d-a23e-9f961881506c.gif  width="40%" height="60%"/>
</p>

