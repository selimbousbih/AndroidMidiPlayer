package com.selimbousbih.midiplayer.midi

class MidiPitchWheel(v1: Int, v2: Int, channel: Int = 0) : MidiEvent(
    PITCH_BEND, channel, v1, v2)