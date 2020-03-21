package com.selimbousbih.midiplayer.midi

class MidiNoteOn(note: Int, velocity: Int, channel: Int = 0) : MidiEvent(
    NOTE_ON, channel, note, velocity)