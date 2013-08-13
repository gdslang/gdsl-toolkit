#!/bin/bash

rm gcc-sweep; make gcc-sweep
./gcc-sweep a.out 1204 32 | less
