<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '사용자 관리' }" />
        <VerticalNavLink
            :item="{
                title: '사용자',
                to: '/users',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '민원 신청 처리' }" />
        <VerticalNavLink
            :item="{
                title: '민원신청',
                to: '/applications',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '문서 발급 및 알림' }" />
        <VerticalNavLink
            :item="{
                title: '알림 발송',
                to: '/notifications',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '발급 내역 문서',
                to: '/resultDocuments',
            }"
        />
    </ul>
</template>
