package com.iflytek.cloud.p023b.p025b;

/* renamed from: com.iflytek.cloud.b.b.b */
final class C0928b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0923a f4433a;

    C0928b(C0923a c0923a) {
        this.f4433a = c0923a;
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x005d in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.f4433a;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0 = r0.f4393b;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1 = com.iflytek.cloud.p023b.p025b.C0923a.C0927a.exiting;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        if (r0 == r1) goto L_0x0063;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
    L_0x000a:
        r0 = r3.f4433a;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0 = r0.f4399u;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        if (r0 != 0) goto L_0x0063;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
    L_0x0010:
        r0 = r3.f4433a;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0 = r0.f4393b;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1 = com.iflytek.cloud.p023b.p025b.C0923a.C0927a.exited;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        if (r0 == r1) goto L_0x0063;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
    L_0x001a:
        r0 = r3.f4433a;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0.mo1571e();	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        goto L_0x0000;
    L_0x0020:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0 = r3.f4433a;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1 = new com.iflytek.cloud.speech.SpeechError;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r2 = 20010; // 0x4e2a float:2.804E-41 double:9.8863E-320;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0.f4402x = r1;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0 = r3.f4433a;
        r0 = r0.f4402x;
        if (r0 == 0) goto L_0x005d;
    L_0x0035:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r3.f4433a;
        r1 = r1.m7051y();
        r0 = r0.append(r1);
        r1 = " occur Error = ";
        r0 = r0.append(r1);
        r1 = r3.f4433a;
        r1 = r1.f4402x;
        r1 = r1.toString();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r0);
    L_0x005d:
        r0 = r3.f4433a;
        r0.mo1572f();
    L_0x0062:
        return;
    L_0x0063:
        r0 = r3.f4433a;
        r0 = r0.f4402x;
        if (r0 == 0) goto L_0x0091;
    L_0x0069:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r3.f4433a;
        r1 = r1.m7051y();
        r0 = r0.append(r1);
        r1 = " occur Error = ";
        r0 = r0.append(r1);
        r1 = r3.f4433a;
        r1 = r1.f4402x;
        r1 = r1.toString();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r0);
    L_0x0091:
        r0 = r3.f4433a;
        r0.mo1572f();
        goto L_0x0062;
    L_0x0097:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1 = r3.f4433a;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1.f4402x = r0;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0 = r3.f4433a;
        r0 = r0.f4402x;
        if (r0 == 0) goto L_0x00cd;
    L_0x00a5:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r3.f4433a;
        r1 = r1.m7051y();
        r0 = r0.append(r1);
        r1 = " occur Error = ";
        r0 = r0.append(r1);
        r1 = r3.f4433a;
        r1 = r1.f4402x;
        r1 = r1.toString();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r0);
    L_0x00cd:
        r0 = r3.f4433a;
        r0.mo1572f();
        goto L_0x0062;
    L_0x00d3:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1 = r3.f4433a;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r2 = new com.iflytek.cloud.speech.SpeechError;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1.f4402x = r2;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0 = r3.f4433a;
        r0 = r0.f4402x;
        if (r0 == 0) goto L_0x010e;
    L_0x00e6:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r3.f4433a;
        r1 = r1.m7051y();
        r0 = r0.append(r1);
        r1 = " occur Error = ";
        r0 = r0.append(r1);
        r1 = r3.f4433a;
        r1 = r1.f4402x;
        r1 = r1.toString();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r0);
    L_0x010e:
        r0 = r3.f4433a;
        r0.mo1572f();
        goto L_0x0062;
    L_0x0115:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1 = r3.f4433a;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r2 = new com.iflytek.cloud.speech.SpeechError;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r1.f4402x = r2;	 Catch:{ IOException -> 0x0020, SpeechError -> 0x0097, InterruptedException -> 0x00d3, Exception -> 0x0115, all -> 0x0157 }
        r0 = r3.f4433a;
        r0 = r0.f4402x;
        if (r0 == 0) goto L_0x0150;
    L_0x0128:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r3.f4433a;
        r1 = r1.m7051y();
        r0 = r0.append(r1);
        r1 = " occur Error = ";
        r0 = r0.append(r1);
        r1 = r3.f4433a;
        r1 = r1.f4402x;
        r1 = r1.toString();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r0);
    L_0x0150:
        r0 = r3.f4433a;
        r0.mo1572f();
        goto L_0x0062;
    L_0x0157:
        r0 = move-exception;
        r1 = r3.f4433a;
        r1 = r1.f4402x;
        if (r1 == 0) goto L_0x0186;
    L_0x015e:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r3.f4433a;
        r2 = r2.m7051y();
        r1 = r1.append(r2);
        r2 = " occur Error = ";
        r1 = r1.append(r2);
        r2 = r3.f4433a;
        r2 = r2.f4402x;
        r2 = r2.toString();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.iflytek.cloud.p023b.p024e.p029a.C0939a.m7120a(r1);
    L_0x0186:
        r1 = r3.f4433a;
        r1.mo1572f();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.b.b.b.run():void");
    }
}
