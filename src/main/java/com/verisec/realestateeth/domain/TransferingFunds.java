package com.verisec.realestateeth.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class TransferingFunds extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50604051602080610714833981016040525160008054600160a060020a03909216600160a060020a03199092169190911790556106c2806100526000396000f3006080604052600436106100a35763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631865c57d81146100a85780631b9265b8146101325780632852b71c1461013c5780632cdf4b7e1461016557806368794b871461017d57806383197ef0146101d657806390672b9d146101eb578063ab04010714610256578063cdc2895c1461026b578063e99d286614610292575b600080fd5b3480156100b457600080fd5b506100bd6102c0565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100f75781810151838201526020016100df565b50505050905090810190601f1680156101245780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61013a610357565b005b34801561014857600080fd5b50610151610505565b604080519115158252519081900360200190f35b34801561017157600080fd5b5061013a600435610518565b34801561018957600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261013a94369492936024939284019190819084018382808284375094975061051d9650505050505050565b3480156101e257600080fd5b5061013a610534565b3480156101f757600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261013a9583359536956044949193909101919081908401838280828437509497505084359550505060208301359260400135915061054f9050565b34801561026257600080fd5b506101516105ad565b34801561027757600080fd5b506102806105bc565b60408051918252519081900360200190f35b34801561029e57600080fd5b5061013a73ffffffffffffffffffffffffffffffffffffffff600435166105c2565b60058054604080516020601f600260001961010060018816150201909516949094049384018190048102820181019092528281526060939092909183018282801561034c5780601f106103215761010080835404028352916020019161034c565b820191906000526020600020905b81548152906001019060200180831161032f57829003601f168201915b505050505090505b90565b60035460ff16156103b25760015460045460405173ffffffffffffffffffffffffffffffffffffffff9092169181156108fc0291906000818181858888f1600380549115156101000261ff0019909216919091179055505050505b600354610100900460ff16156105035760005460028054600654600854600954600a546040517fb4d01dbf0000000000000000000000000000000000000000000000000000000081526004810186815273ffffffffffffffffffffffffffffffffffffffff95861660248301819052606483018690526084830185905260a4830184905260c0604484019081526007805460001960018216156101000201169a909a0460c4850181905297909a169963b4d01dbf9991979196959493909160e490910190879080156104c55780601f1061049a576101008083540402835291602001916104c5565b820191906000526020600020905b8154815290600101906020018083116104a857829003601f168201915b5050975050505050505050600060405180830381600087803b1580156104ea57600080fd5b505af11580156104fe573d6000803e3d6000fd5b505050505b565b6003805460ff1916600190811790915590565b600455565b80516105309060059060208401906105fe565b5050565b60015473ffffffffffffffffffffffffffffffffffffffff16ff5b6006805473ffffffffffffffffffffffffffffffffffffffff19163373ffffffffffffffffffffffffffffffffffffffff161790556002859055835161059c9060079060208701906105fe565b50600892909255600955600a555050565b6003805460ff19169055600090565b60045490565b6001805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff92909216919091179055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061063f57805160ff191683800117855561066c565b8280016001018555821561066c579182015b8281111561066c578251825591602001919060010190610651565b5061067892915061067c565b5090565b61035491905b8082111561067857600081556001016106825600a165627a7a72305820ac0fdb4be729153aaa2a9d9edbe283d2d72081adab255b9adadbd11b5c30584f0029";

    protected TransferingFunds(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TransferingFunds(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> getState() {
        final Function function = new Function("getState", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<TransactionReceipt> setState(String currentState) {
        final Function function = new Function(
                "setState", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(currentState)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> destroy() {
        final Function function = new Function(
                "destroy", 
                Arrays.<Type>asList(), 
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

    public RemoteCall<BigInteger> getOffer() {
        final Function function = new Function("getOffer", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setSeller(String s) {
        final Function function = new Function(
                "setSeller", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<TransferingFunds> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(t)));
        return deployRemoteCall(TransferingFunds.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<TransferingFunds> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String t) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(t)));
        return deployRemoteCall(TransferingFunds.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static TransferingFunds load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferingFunds(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TransferingFunds load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TransferingFunds(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
