
import com.base.utils.model.HttpSendPara;
import com.base.utils.model.RetMsg;
import com.newland.mbop.para.LoginPara;
import com.newland.mbop.para.UserInfo;
import okhttp3.*;
import okio.BufferedSink;

import java.io.*;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Base64;

import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class Main1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String b = "H4sIAAAAAAAAAGxSwU4CMRAdEMSYqICJFy+aePFSPoCbXCRZ1IgxBk7dZVwXu9217SJcjJ/g1cTED9D4IwZvxq/QD/DklEVZo3NpM/Pmdea9Pr5DUSvY9KKQuVwjS0wgNAujHgq2a0zcRtk74IpDGrk8FB2oBtKgOuUeNgTXeo+HaKDq9PmA1wSXfq1tVCD9ugOLVDmLehZxAVeQ68JCTGxOoI2B1W6mZd/to2fqXVi2AGpDdTSKURNxFjZ50BIrNImSFmKg8gcwjA1s2aUkXlK6x0I3ipmb6ECi1qzpRH4gW35IUyz5aI5RBaejBm2dqO+xmKVj07FuXk7uy3pb5AGGsdWBRKvMUDtRJJDL8Ya6fr37/MhDrgPFARcJEpooq1nKdMKHtben53Hn9odxoKDkpjwwi2FM+fV/7TlE09L+zJhSEwoeVRwoneMolbicKmPbajZDyhUEndaMigNzofYnvtA1cvu/TZyu7sA8lVqcFF3JsFHClhTqRFgvM41N+h0+KjLhCwAA//8DALRm5dRfAgAA";
//        byte[] bytes = Base64.getDecoder().decode(b);
        HttpSendPara httpSendPara = new HttpSendPara();
        httpSendPara.methodName = "login";
        httpSendPara.interfaceClassName = "com.newland.mbop.business.ILoginMgmt";
        httpSendPara.paraList = new Object[1];
        httpSendPara.paraList[0] = new LoginPara();
        httpSendPara.parameterTypes = new Class[1];
        httpSendPara.parameterTypes[0] = LoginPara.class;
        httpSendPara.returnType = RetMsg.class;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutput objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(httpSendPara);
        objectOutputStream.close();

        byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gzipOutputStream.write(bytes);
        gzipOutputStream.close();

        bytes = byteArrayOutputStream.toByteArray();
        RequestBody body = RequestBody.create(null, bytes);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8888)))
                .build()
                ;
        Request request = new Request.Builder()
                .url("http://112.5.185.82:8880/MBOP/mbop_services")
                .post(body)
                .build();
        Response response = httpClient.newCall(request).execute();
        System.out.println(response.isSuccessful());
        bytes = response.body().bytes();
        GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(bytes));
        bytes = gzipInputStream.readAllBytes();
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        RetMsg retMsg = (RetMsg) objectInputStream.readObject();
        System.out.println(retMsg.obj.verifyCode);
        System.out.println(retMsg.obj.userOrgld);
    }
}
