package it.wakala.comics

import dagger.Component
import it.wakala.talkrepo.di.comics.ComicsDependencies

@Component(dependencies = [ComicsDependencies::class])
interface ComicsComponent {

    fun inject(fragment: ComicsFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: ComicsDependencies): ComicsComponent
    }

}