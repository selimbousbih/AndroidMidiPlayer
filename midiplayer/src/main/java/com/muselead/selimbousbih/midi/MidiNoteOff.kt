package com.muselead.selimbousbih.midi

class MidiNoteOff(note: Int, velocity: Int = 0, channel: Int = 0) : MidiEvent(
    NOTE_OFF, channel, note, velocity)