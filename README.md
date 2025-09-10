# FabToBottomNavigationAnimation

An Android sample demonstrating how to animate a Floating Action Button (FAB) to a Bottom Navigation View.

## Demo

![Demo Animation](assets/anim.gif)

## Installation

### Option 1: Use as a Local Module

1. Clone the repository:
   ```bash
   git clone https://github.com/RicardoBelchior/FabToBottomNavigationAnimation.git

    //Add the module in your `settings.gradle`:
    gradle include ':app', ':fabtobottomnavigation'
    `
    //Then add the dependency in your `app/build.gradle`:
    gradle implementation project(":fabtobottomnavigation")


### Option 2: Remote dependency

Coming soon — once the library is hosted (e.g., JitPack / MavenCentral).

---

## Usage

```kotlin
val anim = FabToBottomNavigationAnim(fab, bottomNavigationView)

// Show BottomNavigationView (FAB → Nav)
anim.showNavigationView()

// Hide BottomNavigationView (Nav → FAB)
anim.hideNavigationView()
```

---

 `navigationView` can be **any View**, not just Google’s `BottomNavigationView`.

### Methods

* **showNavigationView()**
  Animates the FAB into the navigation view with:

    * curved path motion
    * fade out
    * circular reveal

* **hideNavigationView()**
  Animates the navigation view back into the FAB with:

    * reverse curved path motion
    * fade in
    * reverse circular reveal

---

## Notes

* Works with **any custom view** as the bottom navigation bar.
* Updated for latest Gradle, Kotlin, and AGP versions.

```