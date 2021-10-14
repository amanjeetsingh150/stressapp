while :
do
  adb shell cat proc/meminfo | grep MemFree >> log_free_memory.txt
  sleep 2
done