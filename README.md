# Build Status

[![Join the chat at https://gitter.im/izmailoff/scala-state-example](https://badges.gitter.im/izmailoff/scala-state-example.svg)](https://gitter.im/izmailoff/scala-state-example?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

[![Join the chat at https://gitter.im/izmailoff/scala-state-example](https://badges.gitter.im/izmailoff/scala-state-example.svg)](https://gitter.im/izmailoff/scala-state-example?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/izmailoff/scala-state-example.png?branch=master)](https://travis-ci.org/izmailoff/scala-state-example)

# Test Coverage
[![Coverage Status](https://coveralls.io/repos/izmailoff/scala-state-example/badge.svg?branch=master)](https://coveralls.io/r/izmailoff/scala-state-example?branch=master)
	
# What
This project contains a few examples of dealing with state in Scala. Covers concurrency concerns.
TODO: ... more details when implemented.

# Building

## Prerequisites
Install these applications on your dev machine in order to be able to build the src code:

 * Java Development Kit (JDK) >= 1.7
 * Optionally install SBT, or use one provided with the project (see *sbt* shell scripts)

## Run the project|tests from SBT
SBT is a build tool that downloads source code dependencies, compiles code, runs tests,
generates scaladocs, and produces executables.

Install SBT or get it with `./get_sbt.sh` on Unix.

Start up SBT from Unix/Windows shell:

    > sbt

or if it's not on a PATH:

    > ./sbt

In SBT shell type (note semicolons):

    ;clean; test

You can also run it as a single command from OS shell:

    > sbt clean test

This will run all tests.

Alternatively run:

    > sbt clean run
	
and select one of the executables to run.
    
