package com.mycompany.cryptowallet.repository;

import com.mycompany.cryptowallet.entity.CryptoAsset;
import org.springframework.data.repository.CrudRepository;

public interface CryptoAssetRepository extends CrudRepository<CryptoAsset, String> {

}
