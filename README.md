# FabToBottomNavigationAnimation
Android sample to animate from FAB to BottomNavigation

## Installation

### Option 1: Use as a local module
Clone the repo and include the library in your `settings.gradle`:

```gradle
include ':app', ':fabtobottomnavigation'

Then add the dependency in your app/build.gradle:

implementation project(":fabtobottomnavigation")

Option 2: Remote dependency

Coming soon — once the library is hosted (e.g., JitPack / MavenCentral).

Usage 
val anim = FabToBottomNavigationAnim(fab, bottomNavigationView)

// Show BottomNavigationView (FAB → Nav)
anim.showNavigationView()

// Hide BottomNavigationView (Nav → FAB)
anim.hideNavigationView()

API
Constructor

FabToBottomNavigationAnim(
    FloatingActionButton fabView,
    BottomNavigationView navigationView
)

Methods

showNavigationView()
Animates the FAB into the BottomNavigationView with:

curved path motion

fade out

circular reveal

hideNavigationView()
Animates the BottomNavigationView back into the FAB with:

reverse curved path motion

fade in

reverse circular reveal