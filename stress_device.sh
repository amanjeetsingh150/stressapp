chmod +x ./log_memfree.sh
adb shell /data/local/tmp/stressapptest -s 20 -M 900 -C 8 & sh log_memfree.sh