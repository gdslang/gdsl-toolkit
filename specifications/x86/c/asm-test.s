	.file	"main.c"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc

	#pabsb %mm1, %mm2
	#pabsb %xmm3, %xmm4
	#pabsw %xmm1, %xmm2
	#pabsd %xmm3, %xmm4
	#vpabsb %xmm3, %xmm4
	#vpabsw %xmm1, %xmm2
	#vpabsd %xmm3, %xmm4
	#movd %ebx, %mm5
	#movq %rax, %mm3
	#movd %mm5, %ecx
	#movq %mm3, %rbx
	#vmovd %ebx, %xmm3
	#vmovq %rcx, %xmm1
	#movd (%rcx), %xmm3
	#movq %rbx, %xmm2
	#movd %xmm3, 42(%rbx,%rbp,2)
	#movq %xmm13, %rax
	#vmovd %xmm11, (%rbx)
	#vmovq %xmm7, %rax

	#orq %rax, %rbx

	#notq %rcx

	#negq %r10

	#mulq (%ebx)

	#movsq
	rep movsq

	#movbeq (%rax), %rbx

	#maskmovq %mm3, %mm1
	#vmaskmovdqu %xmm3, %xmm1

	#loop main
	#loope main
	#loopne mainnd _else do
    

	#lodsq
	#rep lodsq

	#lea 24(%rax,%rbx,4), %rcx

	#lgs (%rax), %rbx

	#movdq2q %xmm2, %mm5

	#lahf

	#jmp main
	#jmp %rax

	#test:
	#je test
	#jcxz test
	#jecxz test
	#jrcxz test

	#inc %rax

	#imul (%rax), %rbx

	#div %rax
	#idivq (%rbx)

	#dec %rdx

	#cwd
	#cdq
	#cqo

	#cmpxchg8b (%r10)
	#cmpxchg16b (%r12)

	#cmpxchg %rax, (%rbx)

	#cmpsq

	#cmp %rax, (%rcx)

	#cmova (%rax), %rbx

	#cdqe

        #add (%rax), %rax
        #inc %rax

	#blah:
	#call blah
	#call blah

	#bts %rax, (%rbx)
	#btr %rax, %rbx
	#btc $42, %rbx
	#bt %rax, %rbx

	#bswap %rax

	#bsr (%rax), %rbx
	#bsf %rax, %rbx

	#andpd %xmm1, %xmm2
	#vandpd %xmm1, %xmm2, %xmm3
	#vandpd %ymm1, %ymm2, %ymm3

	#add (%rax), %rbx
	#adc (%rax), %rbx

	#pop %rax
	#push %rbx

	#pushf

	#ret
	#ret $3

	#sahf

	#sal $33, %rax
	#sar %cl, %ecx
	#shlw %cl, (%rbx)
	#shrb $42, (%rax)

	#sbb (%rax), %rbx

	#setg %al
	#setg %ah

	#scasq

	#stc
	#std

	#stosq

	#sub %rax, (%rcx)

	#test %rax, %rcx

	#xadd %rbx, (%rdx)
	#xadd %rbx, %rdx

	#xchg %rbx, (%rdx)
	#xchg %rbx, %rdx

	#xor %rcx, (%r10)

	#nop
	#nop %ax
	#nop %eax

        #packsswb %mm3, %mm4
        #packsswb %xmm3, %xmm4
        #packssdw %mm3, %mm4
        #packssdw %xmm3, %xmm4
        #vpacksswb %xmm2, %xmm3, %xmm4
        #vpackssdw %xmm2, %xmm3, %xmm4

        #packuswb %xmm3, %xmm4
        #vpackusdw %xmm2, %xmm3, %xmm4

	#paddb %xmm3, %xmm5
	#paddw %xmm1, %xmm2
	#paddd %xmm1, %xmm2
	#paddq %xmm1, %xmm2
	#vpaddq %xmm1, %xmm2, %xmm3

	#paddsb %xmm5, %xmm8
	#vpaddsw %xmm1, %xmm9, %xmm4

	#paddusb %xmm5, %xmm8
	#vpaddusw %xmm1, %xmm9, %xmm4

	#palignr $3, %xmm1, %xmm2
	#vpalignr $5, %xmm1, %xmm2, %xmm3

	#pand %mm4, %mm1
	#vpand %xmm1, %xmm2, %xmm3

	#pandn %mm4, %mm1
	#vpandn %xmm1, %xmm2, %xmm3

	#pavgb %mm4, %mm1
	#pavgw %xmm1, %xmm2
	#vpavgw %xmm1, %xmm2, %xmm3

	#pblendvb %xmm1, %xmm2
	#vpblendvb %xmm1, %xmm2, %xmm3, %xmm4

	#pblendw $42, %xmm1, %xmm2
	#vpblendw $42, %xmm1, %xmm2, %xmm3

	#pclmulqdq $1, %xmm1, %xmm2
	#vpclmulqdq $0, %xmm1, %xmm2, %xmm3
	#pclmulqdq $17, %xmm1, %xmm2
	#vpclmulqdq $16, %xmm1, %xmm2, %xmm3

        #pcmpeqb (%rax), %mm4
        #pcmpeqw %xmm3, %xmm4
        #vpcmpeqd (%rax), %xmm4, %xmm2
        #vpcmpeqq %xmm3, %xmm4, %xmm1

        #pcmpgtb (%rax), %mm4
        #pcmpgtw %xmm3, %xmm4
        #vpcmpgtd (%rax), %xmm4, %xmm2
        #vpcmpgtq %xmm3, %xmm4, %xmm1

	#pextrb $3, %xmm1, (%rax)
	#pextrb $3, %xmm1, %rbx
	#pextrw $3, %xmm1, (%rax)
	#pextrw $3, %xmm1, %rcx
	#pextrd $3, %xmm1, (%rax)
	#pextrd $3, %xmm1, %ebx
	#pextrq $3, %xmm1, (%rax)
	#vpextrb $3, %xmm1, (%rax)
	#vpextrb $3, %xmm1, %rbx
	#vpextrw $3, %xmm1, (%rax)
	#vpextrw $3, %xmm1, %rcx
	#vpextrd $3, %xmm1, (%rax)
	#vpextrd $3, %xmm1, %ebx
	#vpextrq $3, %xmm1, (%rax)

	#phaddw %mm2, %mm5
	#vphaddw %xmm1, %xmm2, %xmm5
	#phaddd %xmm4, %xmm2
	#vphaddd %xmm1, %xmm2, %xmm5

	#phaddsw %mm2, %mm5
	#vphaddsw %xmm1, %xmm2, %xmm5

	#phminposuw %xmm1, %xmm2
	#vphminposuw %xmm1, %xmm2

	#phsubw %mm2, %mm5
	#vphsubw %xmm1, %xmm2, %xmm5
	#phsubd %xmm4, %xmm2
	#vphsubd %xmm1, %xmm2, %xmm5

	#phsubsw %mm2, %mm5
	#vphsubsw %xmm1, %xmm2, %xmm5

	#pinsrb $3, %ebx, %xmm1
	#pinsrb $67, (%rax), %xmm1
	#pinsrw $177, (%rax), %xmm1
	#pinsrd $99, %ebx, %xmm1
	#pinsrq $99, %rbx, %xmm1
	#vpinsrb $3, %ebx, %xmm1, %xmm2

	#pmaddubsw %mm1, %mm2
	#pmaddubsw %xmm1, %xmm2
	#vpmaddubsw %xmm1, %xmm2, %xmm3

	#pmaddwd %mm1, %mm2
	#pmaddwd %xmm1, %xmm2
	#vpmaddwd %xmm1, %xmm2, %xmm3

	#pmaxsb %xmm1, %xmm2
	#vpmaxsb %xmm1, %xmm2, %xmm3
	#pmaxsw %mm1, %mm2
	#pmaxsw %xmm1, %xmm2
	#vpmaxsw %xmm1, %xmm2, %xmm3
	#pmaxsd %xmm1, %xmm2
	#vpmaxsd %xmm1, %xmm2, %xmm3

	#pmaxub %mm1, %mm2
	#pmaxub %xmm1, %xmm2
	#vpmaxub %xmm1, %xmm2, %xmm3
	#pmaxuw %xmm1, %xmm2
	#vpmaxuw %xmm1, %xmm2, %xmm3
	#pmaxud %xmm1, %xmm2
	#vpmaxud %xmm1, %xmm2, %xmm3

	#pminsb %xmm1, %xmm2
	#vpminsb %xmm1, %xmm2, %xmm3
	#pminsw %mm1, %mm2
	#pminsw %xmm1, %xmm2
	#vpminsw %xmm1, %xmm2, %xmm3
	#pminsd %xmm1, %xmm2
	#vpminsd %xmm1, %xmm2, %xmm3

	#pminub %mm1, %mm2
	#pminub %xmm1, %xmm2
	#vpminub %xmm1, %xmm2, %xmm3
	#pminuw %xmm1, %xmm2
	#vpminuw %xmm1, %xmm2, %xmm3
	#pminud %xmm1, %xmm2
	#vpminud %xmm1, %xmm2, %xmm3

	#pmovmskb %mm1, %rax
	#pmovmskb %xmm1, %rbx
	#vpmovmskb %xmm1, %rcx

	#pmovsxbw %xmm1, %xmm2
	#pmovsxbd (%rbx), %xmm2
	#pmovsxbq %xmm1, %xmm2
	#pmovsxwd %xmm1, %xmm2
	#pmovsxwq %xmm1, %xmm2
	#pmovsxdq %xmm1, %xmm2
	#vpmovsxbw (%rax), %xmm2
	#vpmovsxbd %xmm1, %xmm2
	#vpmovsxbq (%rcx), %xmm2

	#pmovzxbw %xmm1, %xmm2
	#pmovzxbd (%rbx), %xmm2
	#pmovzxbq %xmm1, %xmm2
	#pmovzxwd %xmm1, %xmm2
	#pmovzxwq %xmm1, %xmm2
	#pmovzxdq %xmm1, %xmm2
	#vpmovzxbw (%rax), %xmm2
	#vpmovzxbd %xmm1, %xmm2
	#vpmovzxbq (%rcx), %xmm2

        #pmuldq %xmm1, %xmm2
        #vpmuldq %xmm1, %xmm2, %xmm3

	#pmulhrsw %mm1, %mm2
	#pmulhrsw %xmm1, %xmm2
	#vpmulhrsw %xmm1, %xmm2, %xmm3

	#pmulhuw %mm1, %mm2
	#pmulhuw %xmm1, %xmm2
	#vpmulhuw %xmm1, %xmm2, %xmm3

	#pmulhw %mm1, %mm2
	#pmulhw %xmm1, %xmm2
	#vpmulhw %xmm1, %xmm2, %xmm3

	#pmulld %xmm1, %xmm2
	#vpmulld %xmm1, %xmm2, %xmm3

	#pmullw %mm1, %mm2
	#pmullw %xmm1, %xmm2
	#vpmullw %xmm1, %xmm2, %xmm3

	#pmuludq %mm1, %mm2
	#pmuludq %xmm1, %xmm2
	#vpmuludq %xmm1, %xmm2, %xmm3

	#popa

	#popcnt %eax, %ebx
	#popcnt %rax, %rbx

	#por %mm1, %mm2
	#por %xmm1, %xmm2
	#vpor %xmm1, %xmm2, %xmm3

	#psadbw %mm1, %mm2
	#psadbw %xmm1, %xmm2
	#vpsadbw %xmm1, %xmm2, %xmm3

	#pshufb %mm1, %mm2
	#pshufb %xmm1, %xmm2
	#vpshufb %xmm1, %xmm2, %xmm3

	#pshufd $0x2d, %xmm1, %xmm2
	#pshufd $0xe1, %xmm1, %xmm2
	#vpshufd $0x59, %xmm1, %xmm2

	#pshufhw $0x2d, %xmm1, %xmm2
	#pshufhw $0xe1, %xmm1, %xmm2
	#vpshufhw $0x59, %xmm1, %xmm2

	#pshuflw $0x2d, %xmm1, %xmm2
	#pshuflw $0xe1, %xmm1, %xmm2
	#vpshuflw $0x59, %xmm1, %xmm2

	#pshufw $0x2d, %mm1, %mm2

	#psignb %mm1, %mm2
	#psignb %xmm1, %xmm2
	#psignw %xmm1, %xmm2
	#psignd (%rax), %xmm2
	#vpsignb %xmm1, %xmm2, %xmm3
	#vpsignw %xmm1, %xmm2, %xmm3
	#vpsignd %xmm1, %xmm2, %xmm3

	#pslldq $73, %xmm1
	#vpslldq $5, %xmm1, %xmm2

	#psllw %mm1, %mm2
	#psllw (%rax), %xmm1
	#psllw $197, %xmm1
	#pslld $20, %mm1
	#psllq $10, %mm1
	#vpslld %xmm1, %xmm2, %xmm3
	#vpsllq $33, %xmm1, %xmm2

	#psrad $42, %xmm1
	#vpsraw $22, %xmm1, %xmm2
	#vpsrad %xmm1, %xmm2, %xmm3

	#psrldq $73, %xmm1
	#vpsrldq $5, %xmm1, %xmm2

	#psrlw %mm1, %mm2
	#psrlw (%rax), %xmm1
	#psrlw $197, %xmm1
	#psrld $20, %mm1
	#psrlq $10, %mm1
	#vpsrld %xmm1, %xmm2, %xmm3
	#vpsrlq $33, %xmm1, %xmm2

	#psubb (%rax), %mm1
	#psubw (%rax), %xmm1
	#psubd %xmm1, %xmm2
	#vpsubd (%rax), %xmm1, %xmm2

	#psubsb (%rax), %mm1
	#psubsw (%rax), %xmm1
	#vpsubsb %xmm1, %xmm2, %xmm3
	#vpsubsw %xmm1, %xmm2, %xmm3

	#psubusb (%rax), %mm1
	#psubusw (%rax), %xmm1
	#vpsubusb %xmm1, %xmm2, %xmm3
	#vpsubusw %xmm1, %xmm2, %xmm3

	#ptest %xmm1, %xmm2
	#vptest %xmm1, %xmm2
	#vptest %ymm1, %ymm2

	#punpckhbw %mm1, %mm2
	#punpckhwd %xmm1, %xmm2
	#punpckhdq %mm1, %mm2
	#punpckhqdq %xmm1, %xmm2
	#vpunpckhbw %xmm1, %xmm2, %xmm3
	#vpunpckhwd %xmm1, %xmm2, %xmm3
	#vpunpckhdq %xmm1, %xmm2, %xmm3
	#vpunpckhqdq %xmm1, %xmm2, %xmm3

	#punpcklbw %mm1, %mm2
	#punpcklwd %xmm1, %xmm2
	#punpckldq %mm1, %mm2
	#punpcklqdq %xmm1, %xmm2
	#vpunpcklbw %xmm1, %xmm2, %xmm3
	#vpunpcklwd %xmm1, %xmm2, %xmm3
	#vpunpckldq %xmm1, %xmm2, %xmm3
	#vpunpcklqdq %xmm1, %xmm2, %xmm3

	#pxor %mm1, %mm2
	#pxor %xmm1, %xmm2
	#vpxor %xmm1, %xmm2, %xmm3

	#rol $42, %al
	#rol %cl, %rax
	#rol $1, %eax

	#ror $42, %al
	#ror %cl, %rax
	#ror $1, %eax

	#rcl $42, %al
	#rcl %cl, %rax
	#rcl $1, %eax

	#rcr $42, %al
	#rcr %cl, %rax
	#rcr $1, %eax

	#and $12, %al
	#and (%rax), %rax
	#and %ebx, %ecx

	#shld $42, %ax, %bx
	#shld $99, %ecx, %edx
	#shld %cl, %rax, %rbx

	#shrd $42, %ax, %bx
	#shrd $99, %ecx, %edx
	#shrd %cl, %rax, %rbx

	#vbroadcastss (%rax), %xmm1
	#vbroadcastss (%rax), %ymm1
	#vbroadcastsd (%rax), %ymm1
	#vbroadcastf128 (%rax), %ymm1

	#vmaskmovps %xmm1, %xmm2, (%rax)
	#vmaskmovps (%rax), %xmm1, %xmm2
	#vmaskmovpd %xmm1, %xmm2, (%rax)
	#vmaskmovpd (%rax), %xmm1, %xmm2
	#vmaskmovpd %ymm1, %ymm2, (%rax)
	#vmaskmovpd (%rax), %ymm1, %ymm2

	#vmovd %xmm5, %ebx

	#movupd %xmm2, %xmm1
	#vmovupd %ymm2, %ymm1
	#vmovupd %xmm2, %xmm1

	#pushq %r14
	##pushl %eax
	#pushw %ax
	#movq %rbx, %r14
	#movq %r13, %r14
	#movq %r13, %rbx

	#addb $42, %al
	#addw $4242, %ax
	#addw $4242, %bx
	#addb $42, %bl
	#nop
	#addb %al, %bl
	#addw %dx, %sp
	#addw $42, %ax
	#addl $42, %eax
	#addl $4242, %eax
	#addq $4242, %rax
	#addq $4242, %r12
	#movq $0xffffffffff, %rax
	#addb $42, 4(%rax,%rbp,2)
	#addb $42, 4(%eax,%ebp,2)
	#addb $42, 4(%eax,%ecx,2)
	#addb $42, 4(%r8,%r9,2)
	#addl $227439052, -1907495376(%r8,%r9,2)
	#movq %rax, %rcx
	#movq %r8, %r9
	#addq %rax, %rcx
	#addq %r8, %r9
	#nop
	#addb $42,(%rax)
	#phaddw %xmm1, %xmm2
	#phaddw %xmm3, %xmm5
	#addq $0xabcdef, %r12

	#push %gs
	#//push %al
	#pushw %ax
	#//pushl %eax
	#pushq %rax

	#addq %rdx, %rcx
	#addq %rdx, %r10
	#addq %r10, %rcx
	#addq %rcx, -4(%rdx, %rax, 2)
	#addq %rcx, -4(%rdx, %r12, 2)
	#addq %rcx, -4(%r11, %r12, 2)

	#vphaddw %xmm1, %xmm2, %xmm3

	#maskmovdqu %xmm2, %xmm1
	#vmaskmovdqu %xmm2, %xmm1

	#vzeroall
	#vzeroupper

	#nop %rax
	#nop %eax
	#nop %ax
	#nop (%rax)

	#movhlps %xmm1, %xmm2
	#movlps (%rax), %xmm1

	#add $0x42, %rax
	#add $0x01bb, %bx
	#add $0x7abbccdd, %rax
	#add $0xaabbccdd12345678, %rax

	#add $0x42, %ecx
	#sar $42, %rax
	#movsx %ax, %rbx
	#add %rax, %rbx
	#add %r8, %rsp
	#add %rsp, %r8
	add (%rsp), %rax
	add $8, %rsp
	movq (%r8), %mm0
	add %r13, %r12
	movupd (%r8), %xmm0
	pand %xmm11, %xmm14

	#pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	#movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movl	$0, %eax
	#popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (Ubuntu/Linaro 4.6.1-9ubuntu3) 4.6.1"
	.section	.note.GNU-stack,"",@progbits
