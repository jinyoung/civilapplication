<template>
    <div>
        <Number label="DocumentId" v-model="value.documentId" :editMode="editMode"/>
        <String label="ApplicationNumber" v-model="value.applicationNumber" :editMode="editMode"/>
        <String label="Recipient" v-model="value.recipient" :editMode="editMode"/>
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
    name: 'ResultDocument',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "resultDocuments"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
