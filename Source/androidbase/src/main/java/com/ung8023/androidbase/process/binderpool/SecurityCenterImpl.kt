package com.ung8023.androidbase.process.binderpool

class SecurityCenterImpl: ISecurityCenter.Stub() {

    override fun encrypt(content: String?): String {
        val toCharArray = content?.toCharArray() ?: return ""

        for (i in 0 until toCharArray.size) {
            toCharArray[i] = (toCharArray[i].toInt() xor
                    SECRET_CODE.toInt()).toChar()
        }
        return String(toCharArray)
    }

    override fun decrypt(password: String?): String {
        return encrypt(password)
    }

    companion object {
        const val SECRET_CODE = '^'
    }
}