package com.centerprime.quarkchainsdk.quarck;

//import com.alwaysfun.quarkchain.quarck.request.CallRequest;
import com.centerprime.quarkchainsdk.quarck.request.CallRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Future;

//import org.tron.api.GrpcAPI;
//import org.tron.protos.Contract;
//import org.tron.protos.Protocol;

/**
 * Base service implementation.
 */
public abstract class Service implements Web3jService {

    private final ObjectMapper objectMapper;

    public Service(boolean includeRawResponses) {
        objectMapper = ObjectMapperFactory.getObjectMapper(includeRawResponses);
    }

    protected abstract InputStream performIO(String payload) throws IOException;

    @Override
    public <T extends Response> T send(
            Request request, Class<T> responseType) throws IOException {
        String payload = objectMapper.writeValueAsString(request);

        InputStream result = performIO(payload);
        if (result != null) {
//            String resource = new Scanner(result).useDelimiter("\\Z").next();
//                Log.e("","------"+resource);
            return objectMapper.readValue(result, responseType);
        } else {
            return null;
        }
    }

    @Override
    public <T extends Response> T send(
            CallRequest request, Class<T> responseType) throws IOException {
        String payload = objectMapper.writeValueAsString(request);

        InputStream result = performIO(payload);
        if (result != null) {
            return objectMapper.readValue(result, responseType);
        } else {
            return null;
        }
    }

    @Override
    public <T extends Response> Future<T> sendAsync(
            Request jsonRpc20Request, Class<T> responseType) {
        return Async.run(() -> Service.this.send(jsonRpc20Request, responseType));
    }

    @Override
    public <T extends Response> Future<T> sendAsync(CallRequest request, Class<T> responseType) {
        return Async.run(() -> Service.this.send(request, responseType));
    }

//    public synchronized GrpcAPI.TransactionExtention triggerSmartContractFunction(TrxRequest request) throws IOException {
//        String payload = objectMapper.writeValueAsString(request);
//        InputStream result = performIO(payload);
//        if (result != null) {
//            GrpcAPI.TransactionExtention.Builder builder = GrpcAPI.TransactionExtention.newBuilder();
//            String resource = parseToString(result);
//            try {
//                JSONObject jsonObject = new JSONObject(resource);
//
//                if (jsonObject.has("result")) {
//                    JSONObject object = jsonObject.getJSONObject("result");
//                    GrpcAPI.Return.Builder resultBuilder = GrpcAPI.Return.newBuilder();
//                    resultBuilder.setResult(object.getBoolean("result"));
//                    builder.setResult(resultBuilder);
//                }
//
//                if (jsonObject.has("txid")) {
//                    String txId = jsonObject.getString("txid");
//                    builder.setTxid(ByteString.copyFrom(Numeric.hexStringToByteArray(txId)));
//                }
//
//                if (jsonObject.has("constant_result")) {
//                    JSONArray jsonArray = jsonObject.getJSONArray("constant_result");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        String value = jsonArray.getString(i);
//                        builder.addConstantResult(ByteString.copyFromUtf8(value));
//                    }
//                }
//
//                if (jsonObject.has("transaction")) {
//                    Protocol.Transaction.Builder transaction = Protocol.Transaction.newBuilder();
//                    JSONObject object = jsonObject.getJSONObject("transaction");
//                    object = object.getJSONObject("raw_data");
//
//                    Protocol.Transaction.raw.Builder raw = Protocol.Transaction.raw.newBuilder();
//                    String refBlockBytes = object.getString("ref_block_bytes");
//                    raw.setRefBlockBytes(ByteString.copyFrom(Numeric.hexStringToByteArray(refBlockBytes)));
//
//                    String refBlockHash = object.getString("ref_block_hash");
//                    raw.setRefBlockHash(ByteString.copyFrom(Numeric.hexStringToByteArray(refBlockHash)));
//
//                    raw.setExpiration(object.getLong("expiration"));
//                    raw.setTimestamp(object.getLong("timestamp"));
//                    if (object.has("fee_limit")) {
//                        raw.setFeeLimit(object.getLong("fee_limit"));
//                    }
//
//                    if (object.has("contract")) {
//                        JSONArray jsonArray = object.getJSONArray("contract");
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject value = jsonArray.getJSONObject(i);
//                            Protocol.Transaction.Contract.Builder contract = Protocol.Transaction.Contract.newBuilder();
//
//                            Any.Builder any = Any.newBuilder();
//                            any.setTypeUrl(value.getJSONObject("parameter").getString("type_url"));
//
//                            Contract.TriggerSmartContract.Builder smartContract = Contract.TriggerSmartContract.newBuilder();
//                            JSONObject smartContractJson = value.getJSONObject("parameter").getJSONObject("value");
//                            String data = smartContractJson.getString("data");
//                            smartContract.setData(ByteString.copyFrom(Numeric.hexStringToByteArray(data)));
//
//                            String ownerAddress = smartContractJson.getString("owner_address");
//                            smartContract.setOwnerAddress(ByteString.copyFrom(Numeric.hexStringToByteArray(ownerAddress)));
//
//                            String contractAddress = smartContractJson.getString("contract_address");
//                            if (contractAddress != null) {
//                                smartContract.setContractAddress(ByteString.copyFrom(Numeric.hexStringToByteArray(contractAddress)));
//                            }
//
//                            any.setValue(smartContract.build().toByteString());
//                            contract.setParameter(any);
//
//                            Protocol.Transaction.Contract.ContractType[] types = Protocol.Transaction.Contract.ContractType.values();
//                            String type = value.getString("type");
//                            for (Protocol.Transaction.Contract.ContractType temp : types) {
//                                if (TextUtils.equals(type, temp.name())) {
//                                    contract.setType(temp);
//                                    break;
//                                }
//                            }
//                            raw.addContract(contract);
//                        }
//                    }
//
//                    transaction.setRawData(raw);
//                    builder.setTransaction(transaction);
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return builder.build();
//        } else {
//            return null;
//        }
//    }

    //inputStream转string
    private String parseToString(InputStream inputStream) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while (result != -1) {
            buf.write((byte) result);
            result = bis.read();
        }

        String value = buf.toString();
        inputStream.close();
        buf.close();
        bis.close();
        return value;
    }
}
