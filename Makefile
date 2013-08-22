export GDSL:=gdsl
export MANAGED:=1

archs:=x86 avr

$(archs):
	$(MAKE) -f Makefile_$@

$(archs:=-clean):
	$(MAKE) -f Makefile_$(@:%-clean=%) clean
