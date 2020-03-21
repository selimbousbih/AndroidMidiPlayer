package com.selimbousbih.midiplayer.midi

import org.billthefarmer.mididriver.MidiDriver

open class MidiEvent(var type: Byte = 0, var channel: Int = 0, var v1: Int = 0, var v2: Int = 0) {

    open fun send(driver: MidiDriver, ch: Int = channel) {
        val msg = ByteArray(3)

        msg[0] = (type+ch).toByte()
        msg[1] = v1.toByte()
        msg[2] = v2.toByte()

        driver.write(msg)
    }

    /**
     * Sends midi message to all used channels from 1 to 6 corresponding to the maximum number of keyboard rows
     */
    open fun sendGlobal(driver: MidiDriver) {
        for(channel in 0 .. 6){
           send(driver, channel)
        }
    }

    override fun toString(): String {
        return "MidiEvent [type: $type  |  v1: $v1  |  v2: $v2]"
    }

    companion object{
        const val NOTE_ON = 0x90.toByte()
        const val NOTE_OFF = 0x80.toByte()
        const val PITCH_BEND = 0xe0.toByte()
        const val PROGRAM_CHANGE = 0xc0.toByte()
    }

}