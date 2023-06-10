package rseditikt.cache

import dev.misfitlabs.kotlinguice4.KotlinModule

/**
 * @author Jordan Abraham
 */
object CacheOSRSModule : KotlinModule() {
    override fun configure() {
        bind<CacheStore>().toProvider<CacheStoreProvider>()
    }
}
