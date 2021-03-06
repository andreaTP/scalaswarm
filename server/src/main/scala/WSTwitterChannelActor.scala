package org.akkajs

import scala.scalajs.js

import akka.actor._

import org.akkajs.messages._

class WSTwitterChannelActor(connection: js.Dynamic) extends Actor {

  override def preStart() = {
    val twitterActor = context.actorOf(Props[TwitterActor])

    connection.on("message", (message: js.Dynamic) => {
      twitterActor ! deserializeTrack(message.utf8Data.toString)
    })

    connection.on("close", (reasonCode: js.Dynamic, description: js.Dynamic) => {
      self ! PoisonPill
    })
  }

  def receive = {
    case tweet: Tweet =>
      connection.send(serialize(tweet))
  }
}
