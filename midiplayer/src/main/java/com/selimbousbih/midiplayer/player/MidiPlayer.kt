package com.selimbousbih.midiplayer.player

import com.selimbousbih.midiplayer.midi.MidiEvent
import org.billthefarmer.mididriver.MidiDriver

class MidiPlayer {
    private val midiDriver = MidiDriver()

    fun init(startListener: MidiDriver.OnMidiStartListener){
        midiDriver.setOnMidiStartListener(startListener)
        midiDriver.start()
    }

    fun play(event: MidiEvent){
        event.send(midiDriver, 0)
    }
}