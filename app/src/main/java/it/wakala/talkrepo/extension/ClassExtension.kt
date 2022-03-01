package it.wakala.talkrepo.extension

import java.lang.reflect.Constructor

fun Class<*>?.getFirstConstructor():Constructor<*>?{
    this?.let {
        if(this.constructors.isEmpty()){
            return null
        }
        return this.constructors[0]
    }
    return null
}

fun Array<Class<*>>?.getSecondParameter():Class<*>?{
    this?.let {
        if(this.isEmpty()){
            return null
        }
        return this[1]
    }
    return null
}

fun Array<Class<*>>?.getFirstParameter():Class<*>?{
    this?.let {
        if(this.isEmpty()){
            return null
        }
        return this[0]
    }
    return null
}