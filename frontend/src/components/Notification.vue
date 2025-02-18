<template>
    <div>
        <Number label="NotificationId" v-model="value.notificationId" :editMode="editMode"/>
        <String label="ApplicationNumber" v-model="value.applicationNumber" :editMode="editMode"/>
        <Date label="SentDate" v-model="value.sentDate" :editMode="editMode"/>
        <String label="Recipient" v-model="value.recipient" :editMode="editMode"/>
        <String label="NotificationMethod" v-model="value.notificationMethod" :editMode="editMode"/>
        <ApplicationId offline label="applicationId" v-model="value.applicationId" :editMode="editMode" @change="change"/>
        <Status offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Notification',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "notifications"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
