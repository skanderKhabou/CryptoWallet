package com.mycompany.cryptowallet.controler;

import com.mycompany.cryptowallet.entity.BinanceTicker;
import com.mycompany.cryptowallet.entity.CryptoAsset;
import com.mycompany.cryptowallet.repository.CryptoAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wallet")
public class CryptoAssetRessource {
@Autowired
CryptoAssetRepository cryptoAssetRepository;

@Autowired
    RestTemplate  restTemplate;

@GetMapping("/{symbol}")
// Recuperation de l'id
// On va récuperer la valeur dynamique dans l url grace add path  variable
CryptoAsset get(@PathVariable String symbol){
        CryptoAsset cryptoAsset =  cryptoAssetRepository.findById(symbol).get();
        cryptoAsset.setPrice(restTemplate.getForObject("https://api.binance.com/api/v3/ticker/24hr?symbol="+symbol+"EUR", BinanceTicker.class).getLastPrice());
return cryptoAsset;
    }
}
