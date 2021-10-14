n=$1
while :
do
  adb shell am broadcast -a me.amanjeet.stressapp.ALLOCATE_NATIVE --ei NUMBER_OF_OBJECTS 3 -p me.amanjeet.stressapp
  sleep 1
done
