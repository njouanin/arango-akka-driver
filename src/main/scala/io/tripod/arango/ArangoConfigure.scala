package io.tripod.arango

import java.net.URI

import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.JavaConversions._

/**
  * Created by njouanin on 27/04/16.
  */

case class ArangoHost(hostName: String, port: Int)

object ArangoHost {
  def apply(url: String ) = {
    val uri = new URI(url)
    new ArangoHost(uri.getHost, uri.getPort)
  }
}


class ArangoConfigure(hostList: List[ArangoHost], user: String, password: String, defaultDatabase: String) {
  //private val hostList = List(config.getList("arangodb.hosts").unwrapped())

  //def nextHost = Iterator.continually(hostList).flatten

}

object ArangoConfigure {
  def apply(): ArangoConfigure = {
    val config = ConfigFactory.load()
    for (host <- config.getStringList("arangodb.hosts")) {

    }
    val hosts = config.getStringList("arangodb.hosts").map( ArangoHost(_) )
    new ArangoConfigure(hosts, "","","")
  }
}