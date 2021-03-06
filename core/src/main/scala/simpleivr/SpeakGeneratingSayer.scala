package simpleivr

import cats.effect.IO


class SpeakGeneratingSayer(interp: IvrCommand.Interpreter[IO],
                           interruptDtmfs: Set[DTMF],
                           speakGenerator: SpeakGenerator) extends DefaultSayer(interp, interruptDtmfs) {
  override def speak(spk: Speaks#Speak) =
    speakGenerator(spk) >>
      super.speak(spk)
}
