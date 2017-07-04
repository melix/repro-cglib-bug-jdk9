import spock.lang.Specification

class ReproSpec extends Specification {
   def "should not throw IllegalArgumentException"() {
      when:
      File file = Mock()

      then:
      noExceptionThrown()
   }
}

