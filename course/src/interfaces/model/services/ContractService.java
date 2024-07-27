package interfaces.model.services;

import java.time.LocalDate;

import interfaces.model.entities.Contract;
import interfaces.model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {

		double basicQuota = contract.getContractValue() / months;

		for (int i = 1; i <= months; i++) {

			double interest = onlinePaymentService.interest(basicQuota, i);
			double fee = onlinePaymentService.paymentFee(interest + basicQuota);
			double quota = basicQuota + interest + fee;
			LocalDate dueDate = contract.getDate().plusMonths(i);

			contract.getInstalments().add(new Installment(dueDate, quota));

		}

	}

}
