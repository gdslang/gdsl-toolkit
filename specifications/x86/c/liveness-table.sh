#!/bin/bash

./liveness-sweep --elf --latex $(for file in examples/* ; do echo "--file $file"; done)
