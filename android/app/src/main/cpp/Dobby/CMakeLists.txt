cmake_minimum_required(VERSION 3.4.1)


set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_C_STANDARD 11)

string(TIMESTAMP TODAY "%Y%m%d")
set(VERSION_REVISION "-${TODAY}")
set(DOBBY_BUILD_VERSION "Dobby${VERSION_REVISION}")
add_definitions(-D__DOBBY_BUILD_VERSION__="${DOBBY_BUILD_VERSION}")

include_directories(./include ./source ./source/include ./source/UserMode ./external/logging ./external/xnucxx ./builtin-plugin ./builtin-plugin/SymbolResolver)

add_library( # Sets the name of the library.
             dobby

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).


./source/core/arch/CpuFeature.cc
./source/core/arch/CpuRegister.cc
./source/core/arch/x86/cpu-x86.cc
./source/core/modules/assembler/assembler.cc
./source/core/modules/assembler/assembler-arm.cc
./source/core/modules/assembler/assembler-arm64.cc
./source/core/modules/codegen/codegen-arm.cc
./source/core/modules/assembler/assembler-ia32.cc
./source/core/modules/assembler/assembler-x64.cc
./source/core/modules/codegen/codegen-arm64.cc
./source/core/modules/codegen/codegen-ia32.cc
./source/core/modules/codegen/codegen-x64.cc
./source/MemoryAllocator/CodeBuffer/CodeBufferBase.cc
./source/MemoryAllocator/CodeBuffer/code-buffer-arm.cc
./source/MemoryAllocator/CodeBuffer/code-buffer-arm64.cc
./source/MemoryAllocator/CodeBuffer/code-buffer-x86.cc
./source/MemoryAllocator/CodeBuffer/code-buffer-x64.cc
./source/MemoryAllocator/AssemblyCodeBuilder.cc
./source/MemoryAllocator/MemoryArena.cc
./source/InstructionRelocation/arm/ARMInstructionRelocation.cc
./source/InstructionRelocation/arm64/ARM64InstructionRelocation.cc
./source/InstructionRelocation/x86/X86InstructionRelocation.cc
./source/InstructionRelocation/x64/X64InstructionRelocation.cc
./source/InstructionRelocation/x86/x86_insn_decode/x86_insn_decode.c
./source/InterceptRouting/InterceptRouting.cpp
./source/TrampolineBridge/Trampoline/arm/trampoline-arm.cc
./source/TrampolineBridge/Trampoline/arm64/trampoline-arm64.cc
./source/TrampolineBridge/Trampoline/x86/trampoline-x86.cc
./source/InterceptRouting/Routing/FunctionInlineReplace/function-inline-replace.cc
./source/TrampolineBridge/Trampoline/x64/trampoline-x64.cc
./source/InterceptRouting/Routing/FunctionInlineReplace/FunctionInlineReplaceExport.cc
./source/InterceptRouting/RoutingPlugin/RoutingPlugin.cc
./source/UserMode/PlatformUtil/Linux/ProcessRuntimeUtility.cc
./source/UserMode/UnifiedInterface/platform-posix.cc
./source/UserMode/ExecMemory/code-patch-tool-posix.cc
./source/UserMode/ExecMemory/clear-cache-tool-all.c
./source/dobby.cpp
./source/Interceptor.cpp
./source/TrampolineBridge/ClosureTrampolineBridge/common-bridge-handler.cc
./source/TrampolineBridge/ClosureTrampolineBridge/arm/helper-arm.cc
./source/TrampolineBridge/ClosureTrampolineBridge/arm/closure-bridge-arm.cc
./source/TrampolineBridge/ClosureTrampolineBridge/arm/ARMAssemblyClosureTrampoline.cc
./source/TrampolineBridge/ClosureTrampolineBridge/arm64/helper-arm64.cc
./source/TrampolineBridge/ClosureTrampolineBridge/arm64/closure-bridge-arm64.cc
./source/TrampolineBridge/ClosureTrampolineBridge/arm64/ARM64AssemblyClosureTrampoline.cc
./source/TrampolineBridge/ClosureTrampolineBridge/x86/closure-bridge-x86.cc
./source/TrampolineBridge/ClosureTrampolineBridge/x86/helper-x86.cc
./source/TrampolineBridge/ClosureTrampolineBridge/x86/X86AssemblyClosureTrampoline.cc
./source/TrampolineBridge/ClosureTrampolineBridge/x64/closure-bridge-x64.cc
./source/TrampolineBridge/ClosureTrampolineBridge/x64/helper-x64.cc
./source/TrampolineBridge/ClosureTrampolineBridge/x64/X64AssemblyClosureTrampoline.cc
./source/UserMode/MultiThreadSupport/ThreadSupport.cpp
./source/UserMode/Thread/PlatformThread.cc
./source/UserMode/Thread/platform-thread-posix.cc
./source/InterceptRouting/Routing/DynamicBinaryInstrument/dynamic-binary-instrument.cc
./source/InterceptRouting/Routing/DynamicBinaryInstrument/DynamicBinaryInstrumentExport.cc
./source/InterceptRouting/Routing/DynamicBinaryInstrument/intercept_routing_handler.cc
./source/InterceptRouting/RoutingPlugin/NearBranchTrampoline/NeaBranchTrampoline.cc
./source/MemoryAllocator/NearMemoryArena.cc
./external/logging/cxxlogging.cc
./external/logging/logging.c
./external/xnucxx/LiteMemOpt.cc
./external/xnucxx/LiteObject.cc
./external/xnucxx/LiteIterator.cc
./external/xnucxx/LiteCollection.cc
./external/xnucxx/LiteMutableBuffer.cc
./external/xnucxx/LiteMutableArray.cc
./builtin-plugin/SymbolResolver/elf/dobby_symbol_resolver.cc
./builtin-plugin/BionicLinkerRestriction/bionic_linker_restriction.cc)

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log)

target_link_libraries( # Specifies the target library.
                       dobby

                       # Links the target library to the log library
                       # included in the NDK.

                       ${log-lib}
)