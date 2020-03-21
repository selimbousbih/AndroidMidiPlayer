package com.muselead.selimbousbih.midi

import org.billthefarmer.mididriver.MidiDriver

class MidiProgramChange(program: Int, channel: Int = 0) : MidiEvent(
    PROGRAM_CHANGE, channel, program) {

    override fun send(driver: MidiDriver, ch: Int) {
        val msg = ByteArray(2)

        msg[0] = (type+ch).toByte()
        msg[1] = v1.toByte()

        driver.write(msg)
    }

    /**
     * Sends midi message to all used channels from 1 to 6 corresponding to the maximum number of keyboard rows
     */
    override fun sendGlobal(driver: MidiDriver) {
        for(channel in 0 .. 6){
            send(driver, channel)
        }
    }

    companion object{
        const val ACOUSTIC_GRAND_PIANO = 0
        const val GUITAR_OVERDRIVE = 29
        const val GUITAR_DISTORTION = 30
        const val SITAR = 104
        const val VIOLIN = 40
        const val STRINGS = 48
        const val SAXOPHONE = 66
        const val FLUTE = 73
        const val FIDDLE = 110
    }
}