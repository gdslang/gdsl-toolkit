import gdsl.Frontend;
import gdsl.Gdsl;
import gdsl.HeapLock;
import gdsl.decoder.Decoder;
import gdsl.decoder.Instruction;
import gdsl.rreil.DefaultRReilBuilder;
import gdsl.rreil.IRReilCollection;
import gdsl.rreil.statement.IStatement;
import gdsl.translator.SemPres;
import gdsl.translator.TranslatedBlock;
import gdsl.translator.TranslatedBlockRaw;
import gdsl.translator.Translator;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Program {
  /**
   * @param args
   * @throws IOException
   */
  private static void sub () {
    Gdsl gdsl = new Gdsl();
    Frontend[] frontends = gdsl.getFrontends();

    HeapLock lock = gdsl.generateHeapLock();

    for (Frontend frontend : frontends) {
      System.out.println(frontend);
    }

    gdsl.setFrontend(frontends[0]);
    gdsl.initFrontend();

    ByteBuffer buffer = ByteBuffer.allocateDirect(5);
    buffer.put((byte) 0);
    buffer.put((byte) 0);
    buffer.put((byte) 0);
    buffer.put((byte) 0);
    buffer.put((byte) 0xc3);

    gdsl.setCode(buffer, 0, 0);

    Translator t = new Translator(gdsl, new DefaultRReilBuilder());

    TranslatedBlock b = t.translateOptimizeBlock(buffer.limit(), SemPres.BLOCK);
    
    for (int i = 0; i < b.getInstructions().length; i++) {
      System.out.println(b.getInstructions()[i]);
    }

    System.out.println("+++++++++++++++++++++++++++++");

    System.out.println(b.getRreil());
  }

  public static void main (String[] args) throws IOException, InterruptedException {
    sub();
    
    System.gc();
    while(true) {
      int[] x = new int[10000];
      x[22] = 99;
      System.out.println(x[33]);
      Thread.sleep(1000);
    }

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
//    IRReilCollection<IStatement> stmts = t.translate(insn);
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
  }
}
