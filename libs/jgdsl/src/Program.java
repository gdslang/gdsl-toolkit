import gdsl.Frontend;
import gdsl.Gdsl;
import gdsl.HeapUseIndicator;
import gdsl.decoder.Decoder;
import gdsl.decoder.NativeInstruction;
import gdsl.rreil.DefaultRReilBuilder;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;
import gdsl.translator.OptimizationConfig;
import gdsl.translator.OptimizationOptions;
import gdsl.translator.TranslatedBlock;
import gdsl.translator.TranslatedBlockRaw;
import gdsl.translator.Translator;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Program {
  /**
   * @param args
   * @throws Throwable
   * @throws IOException
   */
  private static void sub (ByteBuffer buffer) throws Throwable {
    System.out.println("\nsub()\n");

    Frontend[] frontends = Gdsl.getFrontends();

    for (Frontend frontend : frontends) {
      System.out.println("Frontend: " + frontend);
    }

    Gdsl gdsl = new Gdsl(frontends[0]);

    gdsl.setCode(buffer, 0, 0);

    Translator t = new Translator(gdsl, new DefaultRReilBuilder());

    TranslatedBlock b =
      t.translateOptimizeBlock(buffer.limit(), OptimizationOptions.PRESERVE_CONTEXT.and(OptimizationOptions.LIVENESS)
          .and(OptimizationOptions.FSUBST));

//    gdsl.finalize();
//    frontends[0].finalize();
//    
//    System.exit(0);

    for (int i = 0; i < b.getInstructions().length; i++) {
      System.out.println(b.getInstructions()[i]);
    }

    System.out.println("+++++++++++++++++++++++++++++");

    System.out.println(b.getRreil());
  }

  public static void main (String[] args) throws Throwable {
//    ByteBuffer buffer = ByteBuffer.allocateDirect(8);
//    buffer.put((byte) 0x48);
//    buffer.put((byte) 0x83);
//    buffer.put((byte) 0xc0);
//    buffer.put((byte) 0x08);
//    buffer.put((byte) 0x48);
//    buffer.put((byte) 0x03);
//    buffer.put((byte) 0xc8);
//    buffer.put((byte) 0xc3);
  ByteBuffer buffer = ByteBuffer.allocateDirect(5);
  buffer.put((byte) 0xe8);
  buffer.put((byte) 0xae);
  buffer.put((byte) 0xff);
  buffer.put((byte) 0xff);
  buffer.put((byte) 0xff);

    sub(buffer);
//    
//    buffer.put((byte) 0);
//    buffer.put((byte) 0);
//    buffer.put((byte) 0xc3);
//    buffer.put((byte)0x07);
//    buffer.put((byte)0x96);

//    Frontend[] frontends = Gdsl.getFrontends();
//    Gdsl gdsl = new Gdsl(frontends[0]);
//    gdsl.setCode(buffer, 0, 0);
//    
//    Decoder d = new Decoder(gdsl);
//    NativeInstruction nI = d.decodeOne();
//    
//    System.out.println(nI.generalize());
//
//    System.out.println("+++++++++++++++++++++++++++++");

//    for (long i = 0; i < 10000000; i++) {
//      sub(buffer);
//    }
//
//    System.gc();
//    
//    while(true) {
//      int[] x = new int[18000];
//      x[99] = 33;
//      System.out.println(x[1]);
//      Thread.sleep(1000);
//    }

//    Decoder dec = new Decoder(gdsl);
//    Instruction insn = dec.decodeOne();
//    System.out.println(insn);
//
//    int operands = insn.operands();
//    System.out.println("Number of operands: " + operands);
//    for (int i = 0; i < operands; i++) {
//      System.out.println("Operand " + i + ": " + insn.operandToString(i));
//    }
//    System.out.println("-----");
//
//    Translator t = new Translator(gdsl, new DefaultRReilBuilder());
//
//    IRReilCollection<IStatement> stmts = t.translate(nI);
//
//    for (int i = 0; i < stmts.size(); i++) {
//      System.out.println(stmts.get(i));
//    }
//
//    gdsl.resetHeap();
//    gdsl.destroyFrontend();
//    
//    System.out.println("~~~ Done.");

//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//				System.in));
//		while (true) {
//			DefaultRReilBuilder builder = new DefaultRReilBuilder();
//			NativeInterface n = new NativeInterface(builder);
//
//			String[] frontends = n.getFrontends();
//
//			if (frontends.length == 0)
//				throw new RuntimeException("No frontends available");
//
//			int backend_ind = 0;
//
//			if (frontends.length > 1) {
//				System.out.println("Available frontends:");
//				for (int i = 0; i < frontends.length; i++)
//					System.out.println("\t[" + i + "] " + frontends[i]);
//				System.out.print("Your choice? ");
//
//				Scanner in = new Scanner(System.in);
//				backend_ind = in.nextInt();
//				
//				if(backend_ind >= frontends.length)
//					throw new RuntimeException("Invalid frontend");
//			}
//
//			System.out
//					.println("Using frontend " + frontends[backend_ind] + "...");
//
//			n.useFrontend(backend_ind);
//			
//			String line = reader.readLine();
//			if (line == null)
//				break;
//			else if (line.length() == 0)
//				continue;
//
//			System.out.println("Interpreting \"" + line + "\"...");
//
//			ArrayList<Byte> byteList = new ArrayList<Byte>();
//
//			byte next = 0;
//			int part = 0;
//			for (int i = 0; i < line.length(); i++) {
//				char nextChar = line.charAt(i);
//				if (nextChar == 'x') {
//					part = next = 0;
//					continue;
//				} else if (nextChar == ' ')
//					continue;
//				else if (nextChar >= 'a' && nextChar <= 'f')
//					nextChar = (char) ((nextChar - 'a') + 10);
//				else if (nextChar >= '0' && nextChar <= '9')
//					nextChar -= '0';
//				else
//					throw new RuntimeException("Invalid input.");
//				if (part == 0)
//					next = (byte) (nextChar << 4);
//				else {
//					next |= nextChar;
//					byteList.add(next);
//				}
//				part = 1 - part;
//			}
//
//			byte[] bytes = new byte[byteList.size()];
//			for (int i = 0; i < bytes.length; i++)
//				bytes[i] = byteList.get(i);
//
//			System.out.println("Decoding and translating...");
//			IRReilCollection<IStatement> c = n.decodeAndTranslate(bytes);
//
//			n.frontendDescsFree();
//			n.closeBackend();
//
//			// IRReilCollection c = n.decodeAndTranslate(new byte[] { 0x66,
//			// 0x0f,
//			// 0x38, 0x04, (byte) 0xd1 });
//			// IRReilCollection c = n.decodeAndTranslate(new byte[] { 0x66 });
//			// IRReilCollection c = n.decodeAndTranslate(null);
//
//			System.out.println("RReil:");
//
//			for (int i = 0; i < c.size(); i++) {
//				System.out.println(c.get(i));
//			}
//		}
    System.out.println("End");
  }
}
