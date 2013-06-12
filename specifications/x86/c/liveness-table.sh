#!/bin/bash

./liveness-sweep --latex $(for file in examples/* ; do echo "--file $file"; done)
