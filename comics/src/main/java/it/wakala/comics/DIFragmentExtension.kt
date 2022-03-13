package it.wakala.comics

import dagger.hilt.android.EntryPointAccessors
import it.wakala.talkrepo.di.comics.ComicsDependencies

fun ComicsFragment.inject() {
    DaggerComicsComponent.factory()
        .create(
            EntryPointAccessors.fromApplication(
                requireContext(),
                ComicsDependencies::class.java
            )
        ).inject(this)
}