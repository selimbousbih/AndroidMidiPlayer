# MidiPlayer
 
[![](https://jitpack.io/v/selimbousbih/AndroidMidiPlayer.svg)](https://jitpack.io/#selimbousbih/AndroidMidiPlayer)

### Setup
In your project's build.gradle file:

```gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
In your Application's or Module's build.gradle file:
```gradle
implementation 'com.github.billthefarmer:mididriver:v1.17'
implementation 'com.github.selimbousbih:AndroidMidiPlayer:-SNAPSHOT'
```

### Example usage
```kt
class MainActivity : AppCompatActivity(), MidiDriver.OnMidiStartListener {
    private val midiPlayer = MidiPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        midiPlayer.init(this)
    }

    override fun onMidiStart() {
        //Plays middle C (midi number 60) with a velocity of 127
        midiPlayer.play(MidiNoteOn(60, 127))
    }
}
```

### Other usages
```kt
//Get list of midi programs, send midi program change event and play note 
ProgramsDataSource().getPrograms(this).observe(this, Observer { programs ->
    if(programs.isNotEmpty()){
        //Switch to Strings midi instrument
        midiPlayer.play(MidiProgramChange(programs[48].value))
        midiPlayer.play(MidiNoteOn(60, 127))
    }
})
```
