package com.verisec.realestateeth.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class TransferingFounds extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051602080610533833981016040525160008054600160a060020a03909216600160a060020a03199092169190911790556104e1806100526000396000f3006080604052600436106100825763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631b9265b881146100875780632852b71c146100915780632cdf4b7e146100ba57806390672b9d146100d2578063ab0401071461013d578063cdc2895c14610152578063e99d286614610179575b600080fd5b61008f6101a7565b005b34801561009d57600080fd5b506100a6610355565b604080519115158252519081900360200190f35b3480156100c657600080fd5b5061008f600435610369565b3480156100de57600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261008f9583359536956044949193909101919081908401838280828437509497505084359550505060208301359260400135915061036e9050565b34801561014957600080fd5b506100a66103cc565b34801561015e57600080fd5b506101676103db565b60408051918252519081900360200190f35b34801561018557600080fd5b5061008f73ffffffffffffffffffffffffffffffffffffffff600435166103e1565b60035460ff16156102025760015460045460405173ffffffffffffffffffffffffffffffffffffffff9092169181156108fc0291906000818181858888f1600380549115156101000261ff0019909216919091179055505050505b600354610100900460ff161561035357600054600280546005546007546008546009546040517fb4d01dbf0000000000000000000000000000000000000000000000000000000081526004810186815273ffffffffffffffffffffffffffffffffffffffff95861660248301819052606483018690526084830185905260a4830184905260c0604484019081526006805460001960018216156101000201169a909a0460c4850181905297909a169963b4d01dbf9991979196959493909160e490910190879080156103155780601f106102ea57610100808354040283529160200191610315565b820191906000526020600020905b8154815290600101906020018083116102f857829003601f168201915b5050975050505050505050600060405180830381600087803b15801561033a57600080fd5b505af115801561034e573d6000803e3d6000fd5b505050505b565b6003805460ff191660019081179091555b90565b600455565b6005805473ffffffffffffffffffffffffffffffffffffffff19163373ffffffffffffffffffffffffffffffffffffffff16179055600285905583516103bb90600690602087019061041d565b506007929092556008556009555050565b6003805460ff19169055600090565b60045490565b6001805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff92909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061045e57805160ff191683800117855561048b565b8280016001018555821561048b579182015b8281111561048b578251825591602001919060010190610470565b5061049792915061049b565b5090565b61036691905b8082111561049757600081556001016104a15600a165627a7a72305820f42424607990ca759b39da34b8aedbdab415cfb091e599db5d00c6c0f6bf4b700029";

    protected TransferingFounds(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransferingFounds(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> pay(BigInteger weiValue) {
        final Function function = new Function(
                "pay", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> accept() {
        final Function function = new Function(
                "accept", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setOffer(BigInteger proposalAmount) {
        final Function function = new Function(
                "setOffer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(proposalAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeOwner(BigInteger id, String rea, BigInteger a, BigInteger cd, BigInteger p) {
        final Function function = new Function(
                "changeOwner", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(rea), 
                new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(cd), 
                new org.web3j.abi.datatypes.generated.Uint256(p)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> decline() {
        final Function function = new Function(
                "decline", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getOffer() {
        final Function function = new Function(
                "getOffer", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setSeller(String s) {
        final Function function = new Function(
                "setSeller", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<TransferingFounds> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(t)));
        return deployRemoteCall(TransferingFounds.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<TransferingFounds> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(t)));
        return deployRemoteCall(TransferingFounds.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static TransferingFounds load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferingFounds(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TransferingFounds load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferingFounds(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
