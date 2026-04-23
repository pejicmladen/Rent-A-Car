package rentacar.repository;

import rentacar.domain.CarModel;
import rentacar.domain.ContractsModel;
import rentacar.domain.response.RegisterResponseModel;

import java.util.HashMap;
import java.util.List;

public interface ContractRepository {
    RegisterResponseModel add(ContractsModel cm);
    List<ContractsModel> getAllContracts();
    List<ContractsModel> getAllPendingContracts();
    void ContractApproval(boolean isApproved, String contractId);
    List<ContractsModel> getAllUserContracts(String userId);
    HashMap<CarModel, ContractsModel> getAllUserContractsForUser(String userId);
    void ApproveAllContracts();
}
