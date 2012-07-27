package br.uniriotec.vitor.padilha.dissertacao.model.stakeholdersInterests;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.uniriotec.vitor.padilha.dissertacao.XmlFunctionPointElement;
import br.uniriotec.vitor.padilha.dissertacao.exception.ElementException;
import br.uniriotec.vitor.padilha.dissertacao.model.FunctionPointSystem;
import br.uniriotec.vitor.padilha.dissertacao.model.transactionModel.Transaction;

@XmlRootElement(name="stakeholders-interests")
public class StakeholderInterests extends XmlFunctionPointElement {
	
	private List<Stakeholder> stakeholders;
	private List<Interest> interests;
	
	@XmlElementWrapper(name="stakeholders")
	@XmlElement(name="stakeholder")
	public List<Stakeholder> getStakeholders() {
		return stakeholders;
	}
	public void setStakeholders(List<Stakeholder> stakeholders) {
		this.stakeholders = stakeholders;
	}
	@XmlElementWrapper(name="interests")
	@XmlElement(name="interest")
	public List<Interest> getInterests() {
		return interests;
	}
	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public void validade(FunctionPointSystem functionPointSystem, boolean validate) throws ElementException {
		if(interests!=null && functionPointSystem.getTransactionModel()!=null 
				&& functionPointSystem.getTransactionModel().getTransactions()!=null) {
			boolean findTransaction = false;
			boolean findInterest = false;
			for(Interest interest:this.interests) {
				for(Transaction transaction:functionPointSystem.getTransactionModel().getTransactions()) {
					if(interest.getTransactionXML().equals(transaction.getName())) {
						interest.setTransaction(transaction);
						findTransaction=true;
					}
				}
				for(Stakeholder stakeholder:this.stakeholders) {
					if(stakeholder.getName().equals(interest.getStakeholderXML())) {
						interest.setStakeholder(stakeholder);
						findInterest = true;
					}
				}
				if(validate && (!findInterest || !findTransaction)) {
					throw new ElementException("Transação ou grau de interesse não encontrado!", this);
				}
			}
		}
	}
	
}
