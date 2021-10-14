LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
	src/main.cc \
	src/adler32memcpy.cc \
	src/disk_blocks.cc \
	src/error_diag.cc \
	src/finelock_queue.cc \
	src/logger.cc \
	src/os.cc \
	src/os_factory.cc \
	src/pattern.cc \
	src/queue.cc \
	src/sat.cc \
	src/sat_factory.cc \
	src/worker.cc

# Build 64 bit by default
# LOCAL_MULTILIB := 32
LOCAL_MODULE:= stressapptest
LOCAL_MODULE_TAGS := optional

LOCAL_CFLAGS := -DHAVE_CONFIG_H -DANDROID -DNDEBUG -UDEBUG -DCHECKOPTS

LOCAL_CPP_EXTENSION := .cc

include $(BUILD_EXECUTABLE)

