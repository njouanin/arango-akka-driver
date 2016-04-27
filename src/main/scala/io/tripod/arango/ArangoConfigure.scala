package io.tripod.arango

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by njouanin on 27/04/16.
  */
class ArangoConfigure(config: Config=ConfigFactory.load()) {
  private val hostList = List(config.getList("arangodb.hosts").unwrapped())
  val nextHost = Iterator.continually(hostList).flatten

}
