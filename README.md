# BlockingCoroutinesExample
To run yourself, import with Android Studio and run on a device or emulator.

The core code snippet is:
```kotlin
for (i in 0 until 100) {
    launch(CommonPool) {
        Log.d("lol", "coroutine $i start!")
        Thread.sleep(4000)
    }
}
```

Sample output:
```
13:06:16.754 : coroutine 0 start!
13:06:16.755 : coroutine 1 start!
13:06:16.757 : coroutine 2 start!
13:06:20.755 : coroutine 3 start!
13:06:20.756 : coroutine 4 start!
13:06:20.758 : coroutine 5 start!
13:06:24.756 : coroutine 6 start!
13:06:24.757 : coroutine 7 start!
13:06:24.759 : coroutine 8 start!
13:06:28.757 : coroutine 9 start!
13:06:28.758 : coroutine 10 start!
13:06:28.760 : coroutine 11 start!
```

Which amounts to:
```
13:06:16.754 : coroutine 0 start!
13:06:16.755 : coroutine 1 start!
13:06:16.757 : coroutine 2 start!

// PAUSE

13:06:20.755 : coroutine 3 start!
13:06:20.756 : coroutine 4 start!
13:06:20.758 : coroutine 5 start!

// PAUSE

13:06:24.756 : coroutine 6 start!
13:06:24.757 : coroutine 7 start!
13:06:24.759 : coroutine 8 start!

// PAUSE

13:06:28.757 : coroutine 9 start!
13:06:28.758 : coroutine 10 start!
13:06:28.760 : coroutine 11 start!
```

During these pauses, **new coroutines will politely wait until the previous
coroutines run before they can run.**
