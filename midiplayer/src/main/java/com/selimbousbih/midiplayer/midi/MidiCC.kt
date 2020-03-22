package com.selimbousbih.midiplayer.midi

class MidiCC(control: Int, value: Int = 90, channel: Int = 0) : MidiEvent(MIDI_CC, channel, control, value)