package de.ait.GiftManagerPro;

import java.util.ArrayList;
import java.util.List;

public class GiftManager {
    private final List<Gift> gifts; // Список подарков

    // Конструктор для инициализации списка
    public GiftManager() {
        this.gifts = new ArrayList<>();
    }

    // Метод для добавления подарка в список
    public void addGift(Gift gift) {
        gifts.add(gift);
    }

    // Метод для фильтрации подарков по категории
    public List<Gift> filterByCategory(GiftCategory category) {
        List<Gift> filteredGifts = new ArrayList<>();
        for (Gift gift : gifts) {
            if (gift.getCategory() == category) {
                filteredGifts.add(gift);
            }

        }
        return filteredGifts;
    }

    public void updateGiftStatus(String giftName, GiftStatus newStatus) {
        for (Gift gift : gifts) {
            if (gift.getName().equals(giftName)) {
                gift.setStatus(newStatus);
                System.out.println("Update gift: " + gift);
                return;
            }
        }
        System.out.println("Gift not found.");
    }

    public List<Gift> getAllGifts() {
        return gifts;
    }
}