# robolectric-issue-5442-example
An example to fix Robolectric issue 5442 with AGP 7.1.0-alpha08

Cherry-pick https://github.com/robolectric/robolectric/pull/6649/commits/4ce44ee4aec4b33b439bf5d913b21f30cc6504b4 to local robolectric source code, and use command `SKIP_JAVADOC=true ./gradlew publishMavenJavaPublicationToMavenLocal` to build local `robolectric-4.7-SNAPSHOT`, and then execute `./gradlew clean && ./gradlew test` at this project's top directory, all tests should passed.

If we checkout to commit ec687909870a711077b49b2b78bef46b27fd916f to use `robolectric-4.6.1` to run tests, all tests failed.
