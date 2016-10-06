/*
 * This file includes all definitions of the assembly package. It can be
 * used to reduce the amount of include directives required if a client
 * needs many different assembly classes.
 */

#pragma once

#include "cppgdsl/assembly/instruction.h"
#include "cppgdsl/assembly/signedness.h"

#include "cppgdsl/assembly/annotation/annotation_visitor.h"
#include "cppgdsl/assembly/annotation/function_annotation.h"
#include "cppgdsl/assembly/annotation/operand_annotation.h"
#include "cppgdsl/assembly/annotation/string_annotation.h"

#include "cppgdsl/assembly/boundary/boundary.h"
#include "cppgdsl/assembly/boundary/boundary_visitor.h"
#include "cppgdsl/assembly/boundary/offset_boundary.h"

#include "cppgdsl/assembly/operand/annotated.h"
#include "cppgdsl/assembly/operand/bounded.h"
#include "cppgdsl/assembly/operand/composite.h"
#include "cppgdsl/assembly/operand/immediate.h"
#include "cppgdsl/assembly/operand/memory.h"
#include "cppgdsl/assembly/operand/operand_visitor.h"
#include "cppgdsl/assembly/operand/post_op.h"
#include "cppgdsl/assembly/operand/pre_op.h"
#include "cppgdsl/assembly/operand/register.h"
#include "cppgdsl/assembly/operand/rel.h"
#include "cppgdsl/assembly/operand/scale.h"
#include "cppgdsl/assembly/operand/signed.h"
#include "cppgdsl/assembly/operand/sum.h"
