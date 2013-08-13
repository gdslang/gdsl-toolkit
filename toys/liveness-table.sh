#!/bin/bash

./liveness-sweep --cleanup --elf --latex $(for file in examples/* ; do echo "--file $file"; done)
